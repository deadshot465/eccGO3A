//
// Created by 周哲輝 on 2022/03/28.
//

#ifndef CPP_MUSICIAN_H
#define CPP_MUSICIAN_H
#include <algorithm>
#include <atomic>
#include <mutex>
#include <random>
#include <string>
#include <type_traits>
#include <unordered_map>
#include <vector>
#include "SkillLevel.h"

class Musician {
public:
    Musician(std::string  role, const SkillLevel& skillLevel, std::unordered_map<std::string, std::atomic_bool*>& members);
    ~Musician() = default;

    bool play_sound() const noexcept;

private:
    template<typename T = std::mt19937, std::size_t U = T::state_size>
    static typename std::enable_if<U != 0, T>::type get_seeded_engine() {
        typename T::result_type data[U];
        std::random_device rd;
        std::generate(std::begin(data), std::end(data), std::ref(rd));
        std::seed_seq seeds(std::cbegin(data), std::cend(data));
        T engine(seeds);
        return engine;
    }

    static std::string pick_name() noexcept;
    static const std::vector<std::string> first_names;
    static const std::vector<std::string> last_names;
    static std::mt19937 engine;
    static std::mutex mutex;

    std::string m_name = pick_name();
    std::string m_role;
    SkillLevel m_skillLevel;
    std::atomic_bool m_isFired = false;
};


#endif //CPP_MUSICIAN_H
