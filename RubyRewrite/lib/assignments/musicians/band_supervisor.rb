# frozen_string_literal: true

require_relative 'musician'

module BandSupervisor
  DELAY = 0.75

  def self.start_band(max_retries)
    queue = Thread::Queue.new
    members = {
      singer: add_band_member('singer', :good, queue),
      bass: add_band_member('bass', :good, queue),
      drum: add_band_member('drum', :bad, queue),
      guitar: add_band_member('guitar', :good, queue)
    }

    loop do
      new_data = queue.pop
      max_retries -= 1
      if max_retries <= 0
        puts 'The manager is mad and fired the whole band!'
        members.each do |_, q|
          q.enq(0)
        end
        sleep 3.0
        break
      end

      members[new_data[:role]] = add_band_member(new_data[:role], new_data[:skill_level], queue)
    end
  end

  def self.add_band_member(role, skill_level, queue)
    fire_queue = Thread::Queue.new
    musician = Musician.new(role, skill_level, fire_queue)
    Thread.new(musician) do |m|
      loop do
        sleep DELAY
        play_result = m.play_sound
        next if play_result

        queue.enq({ role:, skill_level: })
        break
      end
    end
    fire_queue
  end
end
