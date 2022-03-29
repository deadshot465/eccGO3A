//
// Created by 周哲輝 on 2022/03/28.
//

#include "BandSupervisor.h"
#include <chrono>
#include <iostream>
#include "Musician.h"

std::mutex BandSupervisor::mutex = std::mutex();
std::vector<std::future<void>> BandSupervisor::handles = std::vector<std::future<void>>();

void BandSupervisor::add_band_member(const std::string &role, const SkillLevel &skillLevel, std::deque<std::tuple<std::string, SkillLevel>>& queue, std::unordered_map<std::string, std::atomic_bool*>& members) noexcept {
    auto future = std::async(std::launch::async, [&]() {
        auto musician = Musician(role, skillLevel, members);
        while (true) {
            std::this_thread::sleep_for(std::chrono::milliseconds(delay));
            auto play_result = musician.play_sound();
            if (play_result) {
                continue;
            }

            {
                auto lock = std::lock_guard(mutex);
                queue.emplace_back(std::tuple<std::string, SkillLevel>(role, skillLevel));
            }
            break;
        }
    });
    handles.emplace_back(std::move(future));
}

void BandSupervisor::start_band(int maxRetries) noexcept {
    auto queue = std::deque<std::tuple<std::string, SkillLevel>>();
    auto members = std::unordered_map<std::string, std::atomic_bool*>();
    add_band_member("singer", SkillLevel::GOOD, queue, members);
    add_band_member("bass", SkillLevel::GOOD, queue, members);
    add_band_member("drum", SkillLevel::BAD, queue, members);
    add_band_member("guitar", SkillLevel::GOOD, queue, members);

    do {
        if (queue.empty()) {
            continue;
        }

        auto [role, skill_level] = queue.back();
        queue.pop_back();
        members.erase(role);
        --maxRetries;
        if (maxRetries <= 0) {
            std::cout << "The manager is mad and fired the whole band!\n";
            for (auto& [k, v] : members) {
                v->store(true);
            }
            std::this_thread::sleep_for(std::chrono::seconds(3));
            break;
        }

        add_band_member(role, skill_level, queue, members);
    } while (maxRetries > 0);
}
