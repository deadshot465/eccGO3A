require "./skill_level"

class Musician
    @@first_names = %w[Valerie Arnold Carlos Dorothy Keesha Phoebe Ralphie Tim Wanda Janet Leo Yuhei Carson]
    @@last_names = %w[Frizzle Perlstein Ramon Ann Franklin Terese Tennelli Jamal Li Perlstein Fujioka Ito Hage]

    def initialize(@role : String, @skill_level : SkillLevel, @channel : Channel(Int32))
        @name = Musician.pick_name
        puts "Musician #{@name}, playing the #{@role} entered the room."
    end

    def play_sound
        select
        when @channel.receive
            puts "#{@name} just got back to playing in the subway."
            false
        else
            case @skill_level
            when SkillLevel::Good
                puts "#{@name} produced sound!"
                true
            when SkillLevel::Bad
                failed = rand(0..4) == 0
                if failed
                    puts "#{@name} played a false note. Uh oh."
                    puts "#{@name} sucks! kicked that member out of the band! (#{@role})"
                else
                    puts "#{@name} produced sound!"
                end
                !failed
            else
                true
            end
        end
    end

    def self.pick_name
        first_name = @@first_names[rand(@@first_names.size)]
        last_name = @@last_names[rand(@@last_names.size)]
        "#{first_name} #{last_name}"
    end
end