package handlers

import (
	"github.com/gin-gonic/gin"
	"net/http"
	"stocky/services"
	"database/sql"
)

type RewardRequest struct {
	UserID string  `json:"user_id"`
	Stock  string  `json:"stock"`
	Qty    float64 `json:"quantity"`
	EventID string `json:"event_id"`
}

func RewardHandler(db *sql.DB) gin.HandlerFunc {
	return func(c *gin.Context) {
		var req RewardRequest
		if err := c.ShouldBindJSON(&req); err != nil {
			c.JSON(http.StatusBadRequest, gin.H{"error": err.Error()})
			return
		}

		err := services.CreateReward(db, req.UserID, req.Stock, req.Qty, req.EventID)
		if err != nil {
			c.JSON(http.StatusConflict, gin.H{"error": err.Error()})
			return
		}

		c.JSON(http.StatusOK, gin.H{"status": "rewarded"})
	}
}
