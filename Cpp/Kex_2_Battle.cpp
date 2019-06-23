#include "Kex_2_Battle.h"
#include <iostream>
#include <random>

using std::cout;

bool Kex_2_Battle::CheckHitOrMiss(int hit)
{
	auto engine = Kex_2::GetEngine<>();
	std::uniform_int_distribution<> generator(0, 100);
	int value = generator(engine);
	return value <= hit - 1;
}

int Kex_2_Battle::GetAttackPower()
{
	auto engine = Kex_2::GetEngine<>();
	std::uniform_int_distribution<> generator(0, 40);
	
	return generator(engine) + 60;
}

int Kex_2_Battle::GetSkillPower()
{
	auto engine = Kex_2::GetEngine<>();
	std::uniform_int_distribution<> generator(0, 100);

	return generator(engine) + 30;
}

int Kex_2_Battle::GetMagicPower()
{
	auto engine = Kex_2::GetEngine<>();
	std::uniform_int_distribution<> generator(0, 180);

	return generator(engine) + 20;
}

bool Kex_2_Battle::AttackEnemy(PlayerEx& player, Enemy& enemy)
{
	cout << enemy.Name << "Lv." << enemy.Lv + 1 << "が現れた！\n";

	while (enemy.Hp > 0)
	{
		cout << enemy.Name << " 残りHP：" << enemy.Hp << "\n";
		cout << "武器を選択してください（１．攻撃　２．特技　３．魔法）＞";
		int choice = 0;
		std::cin >> choice;
		int damage = 0;
		bool is_hit = false;
		int (*get_powers[])() = { GetAttackPower, GetSkillPower, GetMagicPower };
		int get_hits[] = { ATTACK_HIT, SKILL_HIT, MAGIC_HIT };
		Attack attacks[3] = {};
		for (int i = 0; i < 3; ++i)
		{
			attacks[i].Damage = get_powers[i]();
			attacks[i].Hit = get_hits[i];
		}

		switch (choice)
		{
		case 1:
			damage = attacks[0].Damage;
			is_hit = CheckHitOrMiss(attacks[0].Hit - enemy.Flee);
			break;
		case 2:
			damage = attacks[1].Damage;
			is_hit = CheckHitOrMiss(attacks[1].Hit - enemy.Flee);
			break;
		case 3:
			damage = attacks[2].Damage;
			is_hit = CheckHitOrMiss(attacks[2].Hit - enemy.Flee);
			break;
		}

		if (is_hit)
		{
			damage -= enemy.Defense;
			if (damage <= 0)
				damage = 0;
			cout << damage << "のダメージ！\n";
			enemy.Hp -= damage;
		}
		else
		{
			cout << "攻撃を外した！\n";
		}

		cout << enemy.Name << "の攻撃！\n";
		is_hit = CheckHitOrMiss(enemy.Hit);
		if (is_hit)
		{
			int injury = enemy.Attack - player.Defense;
			if (injury <= 0)
				injury = 0;
			cout << injury << "のダメージ！\n";
			player.Hp -= injury;
			if (player.Hp <= 0)
			{
				player.Hp = 0;
				cout << "あなたは" << enemy.Name << "に負けました！ゲームオーバー！\n";
				return false;
			}
		}
		else
		{
			cout << "攻撃を外した！\n";
		}

		cout << "プレイヤー残りHP：" << player.Hp << "\n";

		if (enemy.Hp <= 0)
			enemy.Hp = 0;
		if (enemy.Hp == 0)
			cout << enemy.Name << "Lv." << enemy.Lv + 1 << "を倒した！\n";
	}

	return true;
}
