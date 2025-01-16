function submitGuess() {
    const userGuess = document.getElementById("userInput").value;
    const feedback = document.getElementById("feedback");

    if (!userGuess || userGuess < 1 || userGuess > 100) {
        feedback.textContent = "Please enter a valid number between 1 and 100!";
        return;
    }

    fetch(`/game/guess/${userGuess}`)
        .then(response => response.text())
        .then(result => {
            feedback.textContent = result;
        })
        .catch(error => {
            feedback.textContent = "There was an error with the request.";
            console.error("Error:", error);
        });
}
