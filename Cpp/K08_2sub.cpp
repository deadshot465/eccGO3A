#include <iostream>
#include <stdexcept>
#include "Golem.h"
#include "K08_2sub.h"

K08_2sub::K08_2sub()
{
}

K08_2sub::~K08_2sub()
{
}

enum AttackMethod {
	Attack = 65,
	Skill = 99,
	Magic = 133
};

void K08_2sub::AttackGolem(int lv, int& playerHp)
{
	try {
		Golem golem = Golem(lv * 50 + 100, lv * 10 + 40, lv * 10 + 30);

		std::cout << "ゴーレムLv." << lv + 1 << "が現れた！\n";
		while (golem.hp > 0)
		{
			std::cout << "\n残りHP：" << golem.hp << "\n";
			std::cout << "武器を選択してください（１．攻撃　２．特技　３．魔法）＞";
			int choice = 0;
			std::cin >> choice;
			int damage = 0;

			switch (choice)
			{
			case 1:
				damage = static_cast<int>(Attack);
				break;
			case 2:
				damage = static_cast<int>(Skill);
				break;
			case 3:
				damage = static_cast<int>(Magic);
				break;
			default:
				break;
			}
			damage -= golem.defense;

			if (damage <= 0) {
				damage = 0;
				std::cout << "ゴーレム：「ハハハハハ、情けないな！貴様は弱すぎる！」\n";
				std::cout << "ゴーレムがあなたを攻撃しました！攻撃値：" << golem.attack << "\n";
				playerHp -= golem.attack;
				if (playerHp <= 0)
				{
					playerHp = 0;
					std::cout << "あなたはゴーレムに負けました！ゲームオーバー！\n";
					return;
				}
				std::cout << "あなたの残りHPは：" << playerHp << "\n";
			}
			std::cout << "ダメージは" << damage << "です。\n";
			golem.hp -= damage;

			if (golem.hp <= 0)
				golem.hp = 0;
			if (golem.hp == 0)
				std::cout << "ゴーレムLv." << lv + 1 << "を倒した！\n";
		}
	}
	catch (const std::exception& ex) {
		std::cerr << ex.what();
	}
}
