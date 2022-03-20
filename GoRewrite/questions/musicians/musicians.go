package musicians

import (
	"fmt"
	"math/rand"
	"time"
)

const delay = 750

type Musician struct {
	Name       string
	Role       string
	SkillLevel string
	Reader     chan int
}

type MusicianData struct {
	Role       string
	SkillLevel string
}

var (
	firstNames = []string{"Valerie", "Arnold", "Carlos", "Dorothy", "Keesha", "Phoebe", "Ralphie", "Tim", "Wanda",
		"Janet", "Leo", "Yuhei", "Carson"}
	lastNames = []string{"Frizzle",
		"Perlstein",
		"Ramon",
		"Ann",
		"Franklin",
		"Terese",
		"Tennelli",
		"Jamal",
		"Li",
		"Perlstein",
		"Fujioka",
		"Ito",
		"Hage"}
)

func StartBand(maxRetries int) {
	channel := make(chan MusicianData)
	senders := make(map[string]chan int)
	senders["singer"] = addBandMember("singer", "Good", channel)
	senders["bass"] = addBandMember("bass", "Good", channel)
	senders["drum"] = addBandMember("drum", "Bad", channel)
	senders["guitar"] = addBandMember("guitar", "Good", channel)

	for {
		data := <-channel
		maxRetries -= 1
		senders[data.Role] = nil
		if maxRetries <= 0 {
			fmt.Println("The manager is mad and fired the whole band!")
			for _, fireChannel := range senders {
				if fireChannel == nil {
					continue
				}
				fireChannel <- 0
			}
			time.Sleep(3 * time.Second)
			break
		}
		senders[data.Role] = addBandMember(data.Role, data.SkillLevel, channel)
	}
}

func addBandMember(role string, skillLevel string, writer chan MusicianData) chan int {
	fireChannel := make(chan int)
	go func() {
		musician := newMusician(role, skillLevel, fireChannel)
		for {
			time.Sleep(delay * time.Millisecond)
			playResult := musician.PlaySound()
			if playResult {
				continue
			}

			writer <- MusicianData{
				Role:       role,
				SkillLevel: skillLevel,
			}
			break
		}
	}()

	return fireChannel
}

func newMusician(role string, skillLevel string, reader chan int) *Musician {
	name := pickName()
	fmt.Printf("Musician %s, playing %s the entered the room.\n", name, role)
	return &Musician{
		Name:       name,
		Role:       role,
		SkillLevel: skillLevel,
		Reader:     reader,
	}
}

func (m *Musician) PlaySound() bool {
	select {
	case <-m.Reader:
		fmt.Println(m.Name, "just got back to playing in the subway.")
		return false
	default:
		{
			switch m.SkillLevel {
			case "Good":
				fmt.Println(m.Name, "produced sound!")
				return true
			case "Bad":
				failed := rand.Intn(5) == 0
				if failed {
					fmt.Println(m.Name, "played a false note. Uh oh.")
					fmt.Printf("%s sucks! kicked that member out of the band! (%s)\n", m.Name, m.Role)
				} else {
					fmt.Println(m.Name, "produced sound!")
				}

				return !failed
			default:
				return true
			}
		}
	}
}

func pickName() string {
	firstName := firstNames[rand.Intn(len(firstNames))]
	lastName := lastNames[rand.Intn(len(lastNames))]
	return firstName + " " + lastName
}
