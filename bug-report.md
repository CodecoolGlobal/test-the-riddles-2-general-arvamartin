
## The project currently has the following known issues:
* The user can set negative time limit for the answers
* Not able to delete a game lobby
* There is no invite button to invite other players
* The user can create questions without answers
* The user can create and save questions without determine the correct answer
* The user can sign up with invalid, non-existing email address


## Example of the bug report
### User can also sign up with invalid, non-existing email address
**Description**

-   It is possible to sign up with a not valid email address. (email without @- sign, without .com)

**Environment:**

-   Operating System: [Windows 10/11]

-   Browser: [Microsoft Edge, version: 127.0.2651.86.]

**Steps to reproduce:**

-   Click on Sign up button

-   Fill the username input ("test-username")

-   Fill the email input with invalid non-existing email address ("test-email")

-   Fill the password input ("test-password")

-   Click on SIGN UP button

**Expected result:**

-   Error handling, error message (invalid email address)

**Actual result:**

-   There is no error handling, sign up with invalid email address is possible

**These issues are listed in the project's task board in the "TO DO" column and are awaiting resolution.**