require "./musician"
require "./skill_level"

module BandSupervisor
    DELAY = 0.75

    def self.start_band(max_retries : Int32)
        channel = Channel(Tuple(String, SkillLevel)).new
        members = {
            "singer" => add_band_member("singer", SkillLevel::Good, channel),
            "bass" => add_band_member("bass", SkillLevel::Good, channel),
            "drum" => add_band_member("drum", SkillLevel::Bad, channel),
            "guitar" => add_band_member("guitar", SkillLevel::Good, channel),
        }

        loop do
            new_data = channel.receive
            max_retries -= 1
            members.delete(new_data[0])
            if max_retries <= 0
                puts "The manager is mad and fired the whole band!"
                members.each do |_, c|
                    c.send(0)
                end
                sleep 3
                break
            end

            members[new_data[0]] = add_band_member(new_data[0], new_data[1], channel)
        end
    end

    def self.add_band_member(role : String, skill_level : SkillLevel, channel : Channel(Tuple(String, SkillLevel)))
        fire_channel = Channel(Int32).new
        musician = Musician.new(role, skill_level, fire_channel)
        spawn do
            loop do
                sleep DELAY
                play_result = musician.play_sound
                if play_result
                    next
                end

                channel.send(Tuple.new(role, skill_level))
                break
            end
        end
        fire_channel
    end
end