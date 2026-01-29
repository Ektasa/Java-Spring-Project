package routes

import (
	"github.com/gin-gonic/gin"
	"database/sql"
	"stocky/handlers"
)

func Setup(r *gin.Engine, db *sql.DB) {
	r.POST("/reward", handlers.RewardHandler(db))
}
