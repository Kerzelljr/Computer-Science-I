/**********************************************************************
p2dbr077.c  by Ramos, Kerzell
(change the previous line for your abc123 ID and your name)
Purpose:
    This program reads team data to show current rankings.
Command Line Arguments:
    p1  -t  teamFileName  
Input:  
    Stream input file which contains many teams. There are two different 
    kinds of lines of data for each team:
    - Team Identification Information:
        o One line per team (separated by spaces)
            szTeamId  iWins  iLosses  dFeeAmount  dPaidAmount  
             6s       d      d        lf          lf
    - Team Contact Information:
        o One line per team (separated by commas)
            szTeamNm  szEmail szPhone szContactName
            12s       30s     13s     20s
        o Although szTeamNm is a maximum of 12 characters, it may 
          contain spaces; therefore, you cannot simply use %13s.  
          For szFullName, you will have to use a bracket format 
          code using %[^,].  The next two values are also terminated by 
          commas.
        o For szContactName, it contains spaces and is terminated by
          a new line character.  You will have to use a bracket format code 
          using %[^\n]

Results:
    Print the list of teams as shown below.
    Examples:
        Id     Team Name    Wins Loss  Fee Amt   Paid Amt
                        Contact Name         Phone         Email
        UTSA01 Armadillos      8    0    150.00     80.00
                        Jean E Us            (210)555-1111 utsa@xyz.com
        COM001 Comm Eagles     7    1    150.00     75.00
                        Mae King             (210)555-2222 maeking@xyz.com
        SOUTH1 Slam Dunk       5    3    120.00     75.00
                        Jerry Tall           (210)555-3333 slamdunk@gmail.com
        ALHGHT Cake Eaters     4    4    175.00    100.00
                        E Z Street           (210)555-6666 sliverspoon@xyz.com
        UNKN01 Org New Blk     1    7    150.00     50.00
                        Bob Wire             (210)555-1234 bobwire@xyz.com
        NEWB01 River Rats      0    8    120.00     75.00
                        Rock D Boat          (210)555-4444 riverrat@xyz.com
        UNKN02 Hackers         3    5    150.00     75.00
                        Tom E Gunn           (210)555-5555 cyber@gmail.com


Returns:
    0  normal
    -1 invalid command line syntax
    -2 show usage only
    -3 error during processing, see stderr for more information
Notes:
    p1 -?  will provide the usage information.  In some shells,
                you will have to type reserve -\?
  
**********************************************************************/
// If compiling using visual studio, tell the compiler not to give its warnings
// about the safety of scanf and printf
#define _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "cs1713p2.h"

FILE *pFileTeam;               // stream Input for Team data
FILE *pFileGame;		       // stream Input for Game data

//prototypes
void processCommandSwitches(int argc, char *argv[] , char **ppszTeamFileName
												   , char **ppszGameFileName);
void processGameFile(Team teamM[], int iTeamCount);
void processGame(Game game, Team teamM[], int iTeamCount);
int getTeams(Team teamM[]);


int main(int argc, char *argv[])
{
    char *pszTeamFileName = NULL;
	char *pszGameFileName = NULL;

	Team teamM[MAX_TEAMS]; //delclaration for team array
	 
	int iTeamCount; //holds variables for number of teams in array

    // Process the command switches
    processCommandSwitches(argc, argv,  &pszTeamFileName);
    
    // open the Team stream data file
    if (pszTeamFileName == NULL)
        exitError(ERR_MISSING_SWITCH, "-t");
    
    pFileTeam = fopen(pszTeamFileName, "r");
    if (pFileTeam == NULL)
        exitError(ERR_TEAM_FILENAME, pszTeamFileName);

	// open the Game stream data file
	if (pszGameFileName == NULL) {
		exitError(ERR_MISSING_SWITCH, "-t");
	}
   
	pFileGame = fopen(pszGameFileNAme, "r");
	if (pfileGame == NULL) {
		exitError(ERR_TEAM_FILENAME, pszGameFileName);
	}

    //get the Teams Data
    iTeamCount = getTeams(int teamM[]);
	printf("%d", iTeamCount);

	//get the Game Data
	printTeams("Team Information", int teamM[], iTeamCount);

    fclose(pFileTeam);
    printf("\n");    // included so that you can put a breakpoint on this line
    return 0;
}

/******************** printTeams *****************************
void printTeams(char szHeading[], Team teamM[], int iTeamCnt)
Purpose:
Prints team information.
Parameters:
i char szHeading[]  string describing why the teams are printed
(e.g., "Original Team Information")
i Team teamM[]      array of teams
i int iTeamCnt      number of teams
Notes:
Prints two lines of text per team.
**************************************************************************/
void printTeams(char szHeading[], Team teamM[], int iTeamCnt)
{
	int i;          // local counter
					// Print the heading
	printf("%s\n", szHeading);
	printf("  %-6s %-12s %4s %4s  %-8s  %-8s\n"
		, "Id", "Team Name", "Wins", "Loss", "Fee Amt", "Paid Amt");
	printf("\t\t  %-20s %-13s %s\n"
		, "Contact Name", "Phone", "Email");
	// iterate through the teamM array
	for (i = 0; i < iTeamCnt; i++)
	{
		printf("  %-6s %-12s %4d %4d  %8.2lf  %8.2lf\n"
			, teamM[i].szTeamId
			, teamM[i].szTeamName
			, teamM[i].iWins
			, teamM[i].iLosses
			, teamM[i].dFeeAmount
			, teamM[i].dPaidAmount);
		printf("\t\t  %-20s %-13s %s\n"
			, teamM[i].szContactname
			, teamM[i].szPhone
			, teamM[i].szEmailAddr);
	}
}

/*
* Code not entirely my own - did use example for guidance, modified accordindly.
*/

int getTeams(Team teamM[]){

	int iTeamCount;
	int i;
	Team team; //team object
	Team teamM[i] = team;

	for (i = 0; i <= ; i++) {

	}

	char szInputBuffer[100]; 
	int iscanfCnt1; //Count variables, uninitalized.

	//new variables
	int szTeamId1, szTeamId2, iScore1, iScore2;
	char *pszGetTeamResult;
	//
	//fprinf(pfileOutput, "");

	/*printf("%-6s  %-12s  %5s  %5s  %7s  %7s\n", "Id", 
		   "Team Name", "Wins", "Loss", "Fee Amount", "Paid Amount");

	printf("%32s \t %-16s \t %-15s \n", "Contact Name", 
		   "Phone", "Email");*/

	// Read player identification information until EOF
	while (fgets(szInputBuffer, 100, pFileTeam) != NULL){

		iscanfCnt1 = sscanf(szInputBuffer, "%s %d %d %lf %lf"
			, team.szTeamId
			, &team.iWins
			, &team.iLosses
			, &team.dFeeAmount
			, &team.dPaidAmount);

		//should be 5 printf(" >> %d \n", iscanfCnt1);
		if (iscanfCnt1 != 5) {
			exitError("Bad Input Data... \n", szInputBuffer);
		}

		fgets(szInputBuffer, 100, pFileTeam);

		iscanfCnt2 = sscanf(szInputBuffer, "%[^,],%[^,],%[^,], %30[^\n] \n"
			, team.szTeamName
			, team.szEmailAddr
			, team.szPhone
			, team.szContactname);

		//should be 4 printf(" >> %d \n", iscanfCnt2);
		if (iscanfCnt2 != 4) {
			exitError("Bad Input Data... \n", szInputBuffer);
		}

		printf("%-6s  %-12s    %d       %d  %7.2lf  %7.2lf \n", team.szTeamId, team.szTeamName, team.iWins, 
																team.iLosses, team.dFeeAmount, team.dPaidAmount);

		printf("%32s \t %-16s \t %-15s \n", team.szContactname, team.szPhone, team.szEmailAddr);
	}
	printf("\n");

	return iTeamCount;
}

/******************** processCommandSwitches *****************************
void processCommandSwitches(int argc, char *argv[], char **ppszTeamFileName)
Purpose:
    Checks the syntax of command line arguments and returns the filenames.
    If any switches are unknown, it exits with an error.
Parameters:
    I   int argc                    Count of command line arguments
    I   char *argv[]                Array of command line arguments
    O   char **ppszTeamFileName     Team file name
Notes:
    If a -? switch is passed, the usage is printed and the program exits
    with USAGE_ONLY.
    If a syntax error is encountered (e.g., unknown switch), the program
    prints a message to stderr and exits with ERR_COMMAND_LINE_SYNTAX.
**************************************************************************/
void processCommandSwitches(int argc, char *argv[], char **ppszTeamFileName, char **ppszGameFileName)
{
    int i;
    // Examine each command argument (except argument 0 which is the executable name)
    for (i = 1; i < argc; i++)
    {
        // check for a switch
        if (argv[i][0] != '-')
            exitUsage(i, ERR_EXPECTED_SWITCH, argv[i]);
        // determine which switch it is
        switch (argv[i][1])
        {
            case 't':                   // Team File Name
                if (++i >= argc)
                    exitUsage(i, ERR_MISSING_ARGUMENT, argv[i - 1]);
                else
                    *ppszTeamFileName = argv[i];
                break;
            case '?':
                exitUsage(USAGE_ONLY, "", "");
                break;
            default:
                exitUsage(i, ERR_EXPECTED_SWITCH, argv[i]);
        }
    }
}

void processGameFile(Team teamM[], int iTeamCount) {
	processGame();
}

void processGame(Game game, Team teamM[], int iTeamCount) {

}

int findTeam(Team teamM[], int iTeamCount, char szTeamId[]) {
	for (int i = 0; i <= iTeamCount; i++) {
		if (strcmp() == 0) {
			return i;
		}
	}
	return -1;
}

/******************** exitError *****************************
    void exitError(char *pszMessage, char *pszDiagnosticInfo)
Purpose:
    Prints an error message and diagnostic to stderr.  Exits with
    ERROR_PROCESSING.
Parameters:
    I char *pszMessage              error message to print
    I char *pszDiagnosticInfo       supplemental diagnostic information
Notes:
    This routine causes the program to exit.
**************************************************************************/
void exitError(char *pszMessage, char *pszDiagnosticInfo)
{
    fprintf(stderr, "Error: %s %s\n"
        , pszMessage
        , pszDiagnosticInfo);
    exit(ERROR_PROCESSING);
}
/******************** exitUsage *****************************
    void exitUsage(int iArg, char *pszMessage, char *pszDiagnosticInfo)
Purpose:
    If this is an argument error (iArg >= 0), it prints a formatted message
    showing which argument was in error, the specified message, and
    supplemental diagnostic information.  It also shows the usage. It exits
    with ERR_COMMAND_LINE_SYNTAX.

    If this is just asking for usage (iArg will be -1), the usage is shown.
    It exits with USAGE_ONLY.
Parameters:
    I int iArg                      command argument subscript
    I char *pszMessage              error message to print
    I char *pszDiagnosticInfo       supplemental diagnostic information
Notes:
    This routine causes the program to exit.
**************************************************************************/
void exitUsage(int iArg, char *pszMessage, char *pszDiagnosticInfo)
{
    if (iArg >= 0)
        fprintf(stderr, "Error: bad argument #%d.  %s %s\n"
            , iArg
            , pszMessage
            , pszDiagnosticInfo);
    fprintf(stderr, "p1 -t TeamFileName\n");
    if (iArg >= 0)
        exit(-1);
    else
        exit(-2);
}
