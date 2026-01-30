package models

import "time"

type Reward struct {
	ID          string
	UserID      string
	StockSymbol string
	Quantity    float64
	RewardedAt  time.Time
	EventID     string
}
