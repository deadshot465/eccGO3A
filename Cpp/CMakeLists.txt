cmake_minimum_required(VERSION 3.21)
project(cpp)

set(CMAKE_CXX_STANDARD 20)

add_executable(cpp Cpp.cpp
        Golem.h
        IDispatchable.h IDispatchable.cpp
        IExecutable.h IExecutable.cpp
        K01.h K01.cpp K02.h K02.cpp K03.h K03.cpp
        K04.h K04.cpp K05.h K05.cpp K06.h K06.cpp
        K07.h K07.cpp K08.h K08.cpp K08_1sub.h K08_1sub.cpp
        K08_2sub.h K08_2sub.cpp K09.h K09.cpp K10.h K10.cpp
        K11.h K11.cpp K12.h K12.cpp K13.h K13.cpp
        K14.h K14.cpp Kex.h Kex.cpp Kex_1sub.h Kex_1sub.cpp
        Kex_2.h Kex_2.cpp Kex_2_Battle.h Kex_2_Battle.cpp
        Kex_2_Enemy.h Kex_2_Enemy.cpp Musicians/Musician.cpp Musicians/Musician.h Musicians/SkillLevel.h Musicians/BandSupervisor.cpp Musicians/BandSupervisor.h)