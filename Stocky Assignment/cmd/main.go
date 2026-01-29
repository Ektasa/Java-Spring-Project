package main

import (
	"github.com/gin-gonic/gin"
	"github.com/sirupsen/logrus"
	"stocky/config"
	"stocky/db"
	"stocky/routes"
)

func main() {
	logrus.SetFormatter(&logrus.JSONFormatter{})

	cfg := config.Load()
	database, err := db.Connect(cfg)
	if err != nil {
		logrus.Fatal(err)
	}

	r := gin.Default()
	routes.Setup(r, database)

	logrus.Info("Server started on :8080")
	r.Run(":8080")
}
