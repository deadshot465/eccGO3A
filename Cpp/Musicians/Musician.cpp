//
// Created by 周哲輝 on 2022/03/28.
//

#include "Musician.h"

#include <iostream>
#include <utility>

const std::vector<std::string> Musician::first_names = {
        "Valerie", "Arnold", "Carlos", "Dorothy", "Keesha", "Phoebe", "Ralphie", "Tim", "Wanda",
        "Janet", "Leo", "Yuhei", "Carson"
};

const std::vector<std::string> Musician::last_names = {
        "Frizzle",
        "Perlstein",
        "Ramon",
        "Ann",
        "Franklin",
        "Terese",
        "Tennelli",
        "Jamal",
        "Li",
        "Perlstein",
        "Fujioka",
        "Ito",
        "Hage"
};

std::mt19937 Musician::engine = Musician::get_seeded_engine();
std::mutex Musician::mutex = std::mutex();

std::string Musician::pick_name() noexcept {
    auto rng = std::uniform_int_distribution<int>(0, first_names.size() - 1);
    auto index = rng(engine);
    auto& first_name = first_names[index];
    const auto new_params = std::uniform_int_distribution<int>::param_type(0, last_names.size() - 1);
    rng.param(new_params);
    index = rng(engine);
    auto& last_name = last_names[index];
    return first_name + " " + last_name;
}

Musician::Musician(std::string role, const SkillLevel &skillLevel, std::unordered_map<std::string, std::atomic_bool*>& members) : m_role(std::move(role)), m_skillLevel(skillLevel)  {
    {
        auto lock = std::lock_guard(mutex);
        members.emplace(m_role, &m_isFired);
    }
    std::cout << "Musician " << m_name << ", playing the " << m_role << " entered the room.\n";
}

bool Musician::play_sound() const noexcept {
    const auto is_fired = m_isFired.load();
    if (is_fired) {
        std::cout << m_name << " just got back to playing in the subway.\n";
        return false;
    }

    switch (m_skillLevel) {
        case SkillLevel::GOOD:
            std::cout << m_name << " produced sound! (" << &m_isFired << ")\n";
            return true;
        case SkillLevel::BAD:
        {
            auto rng = std::uniform_int_distribution(0, 4);
            const auto failed = rng(engine) == 0;
            if (failed) {
                std::cout << m_name << " played a false note. Uh oh.\n";
                std::cout << m_name << " sucks! kicked that member out of the band!\n";
            } else {
                std::cout << m_name << " produced sound! (" << &m_isFired << ")\n";
            }

            return !failed;
        }
        default:
            return true;
    }
}

