*** Settings ***

Library  BuiltIn
Library  OperatingSystem
Library  Collections

*** Variables ***

${jarName}      tau6-1.0-SNAPSHOT.jar
${targetPath}   ..${/}app${/}target
${jarPath}      ${targetPath}${/}${jarName}
${exec}         java -jar ${jarPath}


*** Test cases ***
TC_001 Setup
    Directory Should Exist  ${targetPath}
    File Should Exist       ${jarPath}

TC_002 Figures
    [Template]  Figures
    # lengths   # exptectedResult
    2 2 2       trójkąt równoboczny
    1 2 2       trójkąt równoramienny
    3 4 5       trójkąt różnoboczny
    10 1 1      nierozpoznano
    1 2 3       nierozpoznano
    5 6 0       nierozpoznano
    0 0 0       nierozpoznano

    2 2 2 2    kwadrat
    2 3 3 2    prostokąt
    1 2 3 4    czworobok
    12 4 4 4   nierozpoznano
    5 5 5 20   nierozpoznano
    0 0 0 0    nierozpoznano

    1          nierozpoznano
    1 2        nierozpoznano
    a b c      nierozpoznano
    1 2 3 4 5  nierozpoznano

*** Keywords ***

Figures
    [Arguments]  ${lengths}  ${expectedResult}

    ${output} =  Run  ${exec} ${lengths}

    Should Be Equal  ${output}  ${expectedResult}



