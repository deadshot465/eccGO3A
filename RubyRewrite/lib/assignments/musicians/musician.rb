class Musician
  attr_reader :name, :role

  @@first_names = %w[Valerie Arnold Carlos Dorothy Keesha Phoebe Ralphie Tim Wanda Janet Leo Yuhei Carson]
  @@last_names = %w[Frizzle Perlstein Ramon Ann Franklin Terese Tennelli Jamal Li Perlstein Fujioka Ito Hage]

  def initialize(role, skill_level, queue)
    @name = Musician.pick_name
    @role = role
    @skill_level = skill_level
    @queue = queue
    puts "Musician #{@name}, playing the #{@role} entered the room."
  end

  def play_sound
    is_fired = @queue.empty?
    unless is_fired
      puts "#{@name} just got back to playing in the subway."
      return false
    end

    case @skill_level
    when :good
      puts "#{@name} produced sound!"
      true
    when :bad
      failed = rand(0..4).zero?
      if failed
        puts "#{@name} played a false note. Uh oh."
        puts "#{@name} sucks! kicked that member out of the band! (#{@role})"
        false
      else
        puts "#{@name} produced sound!"
        true
      end
    else
      true
    end
  end

  def self.pick_name
    first_name = @@first_names[rand(@@first_names.length)]
    last_name = @@last_names[rand(@@last_names.length)]
    "#{first_name} #{last_name}"
  end
end
