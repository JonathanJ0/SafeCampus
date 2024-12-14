const express = require("express");
const bodyParser = require("body-parser");

const app = express();
const port = 3000;

// Middleware
app.use(bodyParser.json());

const reports = [];
const chats = [];

// Submit Report
app.post("/submit-report", (req, res) => {
  const reportId = `RPT-${Math.floor(1000 + Math.random() * 9000)}`;
  const report = { ...req.body, reportId };
  reports.push(report);
  res.json({ reportId });
});

// Track Report
app.get("/track-report/:id", (req, res) => {
  const report = reports.find((r) => r.reportId === req.params.id);
  if (report) {
    res.json({ status: "Pending Review" });
  } else {
    res.status(404).json({ error: "Report not found" });
  }
});

// Chat
app.post("/send-message", (req, res) => {
  const message = req.body.message;
  chats.push({ message, timestamp: new Date() });
  res.json({ success: true });
});

// Start Server
app.listen(port, () => console.log(`Server running on http://localhost:${port}`));
