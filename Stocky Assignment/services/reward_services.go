package services

import (
	"database/sql"
	"github.com/google/uuid"
)

func CreateReward(db *sql.DB, userID, stock string, qty float64, eventID string) error {
	id := uuid.New()

	_, err := db.Exec(`
		INSERT INTO rewards(id, user_id, stock_symbol, quantity, rewarded_at, event_id)
		VALUES($1,$2,$3,$4,now(),$5)
	`, id, userID, stock, qty, eventID)

	if err != nil {
		return err
	}

	// Ledger entries
	price := GetMockPrice(stock)
	cost := price * qty
	fees := cost * 0.002

	db.Exec(`INSERT INTO ledger_entries VALUES($1,$2,'STOCK',$3,$4,0,now())`,
		uuid.New(), id, stock, qty)

	db.Exec(`INSERT INTO ledger_entries VALUES($1,$2,'CASH',NULL,0,$3,now())`,
		uuid.New(), id, cost)

	db.Exec(`INSERT INTO ledger_entries VALUES($1,$2,'FEES',NULL,0,$3,now())`,
		uuid.New(), id, fees)

	return nil
}
