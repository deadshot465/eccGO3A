import 'dart:math';

import 'package:Dart/Enemy.dart';
import 'package:Dart/Golem.dart';

enum EnemyType {
  TYPE_GOLEM,
  TYPE_GOBLIN,
  TYPE_SLIME
}

const MAX_GOLEM_LEVEL = 4;
const MAX_GOBLIN_LEVEL = 6;
const MAX_SLIME_LEVEL = 8;
const GOBLIN_HIT = 85;
const GOBLIN_FLEE = 40;
const SLIME_HIT = 95;
const SLIME_FLEE = 30;

Enemy CreateEnemy(EnemyType type) {
  Enemy enemy = Enemy();
  Random rand = Random();
  switch (type) {
    case EnemyType.TYPE_GOLEM:
      int lv = rand.nextInt(MAX_GOLEM_LEVEL);
      enemy.Lv = lv;
      enemy.Hp = lv * 50 + 100;
      enemy.Defense = lv * 10 + 40;
      enemy.Attack = lv * 10 + 40;
      enemy.Hit = GOLEM_HIT;
      enemy.Flee = GOLEM_FLEE;
      enemy.Name = 'ゴーレム';
      break;
    case EnemyType.TYPE_GOBLIN:
      int lv = rand.nextInt(MAX_GOBLIN_LEVEL);
      enemy.Lv = lv;
      enemy.Hp = lv * 30 + 75;
      enemy.Defense = lv * 5 + 20;
      enemy.Attack = lv * 5 + 20;
      enemy.Hit = GOBLIN_HIT;
      enemy.Flee = GOBLIN_FLEE;
      enemy.Name = 'ゴブリン';
      break;
    case EnemyType.TYPE_SLIME:
      int lv = rand.nextInt(MAX_SLIME_LEVEL);
      enemy.Lv = lv;
      enemy.Hp = lv * 10 + 50;
      enemy.Defense = lv * 2 + 10;
      enemy.Attack = lv * 2 + 10;
      enemy.Hit = SLIME_HIT;
      enemy.Flee = SLIME_FLEE;
      enemy.Name = 'スライム';
      break;
  }
  return enemy;
}