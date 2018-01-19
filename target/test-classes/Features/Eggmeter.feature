Feature: Countdown.feature

  @one
  Scenario: Verify Eggmeter home page is loaded and user able to start the counter
    Given Eggmeter timer site is opened and page is loaded
    When User enter's time and click Go
    |time|
    |25seconds|
    |2minutes |
    Then Countdown timer should start
    And Remaining time decreases in one-sec increments

  Scenario Outline: Verify Eggmeter home page is loaded and user able to start the counter using scenarios outline
    Given Eggmeter timer site is opened and page is loaded
    When User enter's <Countdowntimes> and click Go
    Then Countdown timer should start
    And Remaining time decreases in one-sec increments

    Examples:
      |Countdowntimes|
      |25seconds|
      |2minutes |