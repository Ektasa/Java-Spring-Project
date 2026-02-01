package services

import (
	"math/rand"
	"time"
)

func GetMockPrice(stock string) float64 {
	rand.Seed(time.Now().UnixNano())
	return float64(500 + rand.Intn(3000))
}
