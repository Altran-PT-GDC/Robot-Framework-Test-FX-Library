*** Settings ***
Library           TestFXLibrary
Library           Dialogs
Suite Setup       Start Application     testapp.FxApplicationUnitTest
Suite Teardown    Close Application

*** Test Cases ***
Test Start Application
     Close Application
     Start Application  testapp.FxApplicationUnitTest
     Close Application

Test Multiple Start Application Overload KeyWord
     Start Application  testapp.FxApplicationUnitTest  distinctiveName=app1
     Start Application  testapp.FxApplicationUnitTest  distinctiveName=app2
     Close Application

Test Start Application With Custom Arguments
     @{arguments_list}=    Create List    ArgumentNumber1    ArgumentNumber2   ArgumentNumber3
     Start Application   testapp.FxApplicationUnitTest    Application1    @{arguments_list}
     ${expected_text}=    Catenate    SEPARATOR=;    @{arguments_list}
     Text Field Text Should Be    \#textfield    ${expected_text}
     Close Application

Test Switch Application
     Start Application  testapp.FxApplicationUnitTest  distinctiveName=app1
     Start Application  testapp.FxApplicationUnitTest  distinctiveName=app2
     Switch Application     app1
     Close Application
     [Teardown]     Start Application   testapp.FxApplicationUnitTest

Test Switch Application not exist
     Start Application  testapp.FxApplicationUnitTest  distinctiveName=app1
     Start Application  testapp.FxApplicationUnitTest  distinctiveName=app2
     ${listApp} =   Switch Application     app4
     Close Application
     [Teardown]     Start Application   testapp.FxApplicationUnitTest

Test Sleep
     ${before_kw_time}=   Get Time      sec
     TestFXLibrary.Sleep      1
     ${after_kw_time}=   Get Time       sec
     ${time_passed}=    Set Variable    ${${after_kw_time}}-${${before_kw_time}}
     Evaluate   ${time_passed} < 1

Test Get NTH Element
     ${default_element}=    Set Variable    VBox[id=vbuttons1]
     ${node}=   Get Nth Element  \#vbuttons1[0]
     Should Be Equal    "${node}"     "${default_element}"

Test Get Component Attribute
     ${default_value}=      Set Variable    false
     ${attribute}=      Get Component Attribute    \#checkbox     isSelected
     Should Be Equal    ${${attribute}}     ${${default_value}}

Test List Component Methods
     List Component Methods    \#vbuttons1[0]

Test List Components In Context
     ${component_context}=       List Components In Context
     Should Not Be Empty    ${component_context}

Test Get Node All
     Get Node All       \#vbuttons1[0]





