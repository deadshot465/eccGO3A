package io.github.deadshot465.assignments.musicians;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BandSupervisor {
    private static final BlockingQueue<MusicianData> queue = new ArrayBlockingQueue<>(100);

    public static void startBand(int maxRetries) throws InterruptedException {
        final var members = new HashMap<String, Musician>();
        members.put("singer", addBandMember("singer", SkillLevel.Good));
        members.put("bass", addBandMember("bass", SkillLevel.Good));
        members.put("drum", addBandMember("drum", SkillLevel.Bad));
        members.put("guitar", addBandMember("guitar", SkillLevel.Good));

        while (true) {
            var newMusicianData = queue.poll(1000, TimeUnit.MILLISECONDS);
            if (newMusicianData == null) {
                continue;
            }

            maxRetries--;
            members.remove(newMusicianData.role());
            if (maxRetries <= 0) {
                System.out.println("The manager is mad and fired the whole band!");
                for (var musician :
                        members.values()) {
                    musician.setFired(true);
                }
                Thread.sleep(3000);
                break;
            }
            members.put(newMusicianData.role(), addBandMember(newMusicianData.role(), newMusicianData.skillLevel()));
        }
    }

    private static Musician addBandMember(String role, SkillLevel skillLevel) {
        final var musician = new Musician(role, skillLevel);
        final var thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(Musician.delay);
                    final var playResult = musician.playSound();
                    if (playResult) {
                        continue;
                    }

                    queue.add(new MusicianData(role, skillLevel));
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        return musician;
    }
}
