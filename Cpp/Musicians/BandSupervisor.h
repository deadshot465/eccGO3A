//
// Created by 周哲輝 on 2022/03/28.
//

#ifndef CPP_BANDSUPERVISOR_H
#define CPP_BANDSUPERVISOR_H
#include <atomic>
#include <deque>
#include <future>
#include <mutex>
#include <string>
#include <tuple>
#include <unordered_map>
#include <vector>
#include "SkillLevel.h"

class BandSupervisor final {
public:
    static void add_band_member(const std::string& role, const SkillLevel& skillLevel, std::deque<std::tuple<std::string, SkillLevel>>& queue, std::unordered_map<std::string, std::atomic_bool*>& members) noexcept;
    static void start_band(int maxRetries) noexcept;
private:
    BandSupervisor() = default;

    static constexpr int delay = 750;
    static std::mutex mutex;
    static std::vector<std::future<void>> handles;
};


#endif //CPP_BANDSUPERVISOR_H
