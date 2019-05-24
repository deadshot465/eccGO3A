#pragma once

#include <random>

#include "Kex.h"

class Kex_1sub
{
public:
	static void AttackGolem(int lv, PlayerEx& player);

	template <typename T = std::mt19937, std::size_t N = T::state_size>
	static typename std::enable_if<!!N, T>::type GetSeededEngine();
};

template <typename T, std::size_t N>
typename std::enable_if<!!N, T>::type Kex_1sub::GetSeededEngine()
{
	typename T::result_type random_data[N];
	std::random_device rd;
	std::generate(std::begin(random_data), std::end(random_data), std::ref(rd));
	std::seed_seq seeds(std::begin(random_data), std::end(random_data));
	T seeded_engine(seeds);
	return seeded_engine;
}