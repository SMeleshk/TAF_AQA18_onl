Feature: Начальный тест для изучения Cucumber

  Scenario: Простой тест без тела

  Scenario: Простой тест с Given
    Given открыт браузер

  Scenario: простой тест с Given и When
    Given открыт браузер
    When страница логина открыта

  Scenario: простой тест со всеми ключевыми словами
    Given открыт браузер
    When страница логина открыта
    Then поле username отображается

  Scenario: использование AND
    Given открыт браузер
    And страница логина открыта
    Then поле username отображается
    * поле password отображается

  Scenario: использование BUT
    Given открыт браузер
    And страница логина открыта
    Then поле username отображается
    But ошибка не отображается
