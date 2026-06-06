package models;

public class ScenarioResult {

    private String scenarioId;
    private String status;
    private String remarks;

    public ScenarioResult(String scenarioId,
                          String status,
                          String remarks) {

        this.scenarioId = scenarioId;
        this.status = status;
        this.remarks = remarks;
    }

    public String getScenarioId() {
        return scenarioId;
    }

    public String getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }
}