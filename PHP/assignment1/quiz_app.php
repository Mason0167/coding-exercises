<style>
    select, button{
        padding: 5px;
        border-radius: 5px;
        text-align: center;
    }
    h2{
        color: blue;
    }
</style>
<script>
    function checkTopic(){
        let topicSelected = document.getElementById("topicButton");
        // Extract DOM element "topicButton"

        if(topicSelected.value === ""){
            alert("Select a category.")
            return;
            // Stop here, do not submit
        }
        document.getElementById("topicForm").submit();
        // submit the form when user select a topic
    }
</script>
<?php

echo '<form id="topicForm" method="POST" action="">';
// <form method=""> => Send the data to php
// action="" => tell browser sends data to the same page or specific page

echo '<select id="topicButton" name="topicButton">';
// id => for js, name => for php

echo '<option value="">Select a category</option>';
echo '<option value="Trivia">Trivia</option>';
echo '<option value="Psychology">Psychology</option>';
echo '<option value="Canadian Politics">Canadian Politics</option>';

echo '</select>';
echo '<br><br>';

echo '<button type="button" onclick="checkTopic()">Submit</button>';
// type="button" allows program to run js first
// Nothing happens unless you add JavaScript (onclick).

echo '<br><br><br><br><br><br>';
echo '</form>';

$quizArray = [
        "trivia" => [
                [
                        "Question" => "How does a camera keeps its lens clean when it is pouring rain?",
                        "Options" =>  [
                                "1" => "The lens can spin very fast and shake the raindrop off.",
                                "2" => "The raindrops won't affect the camera.",
                                "3" => "Put on the rain covers to prevent water from damaging the camera.",
                                "4" => "All of the above"
                        ],
                        "Answer" => [
                                "The lens can spin very fast and shake the raindrop off.",
                                "Put on the rain covers to prevent water from damaging the camera."
                        ]
                ],
                [
                        "Question" => "The Eiffel Tower grows taller in summer. Yes or No",
                        "Options" => [
                                "1" => "Yes",
                                "2" => "No",
                        ],
                        "Answer" => ["Yes"]
                ],
                [
                        "Question" => "Which U.S. president's parrot cursed so much it was kicked out of his funeral.",
                        "Options" => [
                                "1" => "Donald Trump",
                                "2" => "Abraham Lincoln",
                                "3" => "Andrew Jackson",
                                "4" => "Nothing like that happened",
                        ],
                        "Answer" => ["Andrew Jackson"]
                ]
        ],
        "psychology" => [
                [
                        "Question" => "What color can make you feel hungrier just by looking at it?",
                        "Options" =>  [
                                "1" => "Red",
                                "2" => "white",
                                "3" => "black",
                        ],
                        "Answer" => ["Red"]
                ],
                [
                        "Question" => "If you write down your worries on paper and throw the paper away, what happens?",
                        "Options" => [
                                "1" => "Nothing will happen",
                                "2" => "Feel less stressed",
                                "3" => "You wasted a paper and feel more stressed",
                        ],
                        "Answer" => ["Feel less stressed"]
                ],
                [
                        "Question" => "Which of these are real psychological syndromes?",
                        "Options" => [
                                "1" => "Alice in Wonderland Syndrome",
                                "2" => "Truman Show Delusion",
                                "3" => "Pinocchio Syndrome",
                                "4" => "Paris Syndrome",
                        ],
                        "Answer" => ["Pinocchio Syndrome"]
                ]
        ],
        "politics" => [
                [
                        "Question" => "Which Canadian prime minister was in office for just 79 days, making it the shortest term in history?",
                        "Options" =>  [
                                "1" => "Kim Campbell",
                                "2" => "John Turner",
                                "3" => "R.B. Bennett"
                        ],
                        "Answer" => ["John Turner"]
                ],
                [
                        "Question" => "Canada has had a father and son both serve as prime ministers. (True or False)",
                        "Options" => [
                                "1" => "Yes",
                                "2" => "No",
                        ],
                        "Answer" => ["Yes"]
                ],
                [
                        "Question" => "Which of these political parties currently exist in Canada?",
                        "Options" => [
                                "1" => "Liberal Party",
                                "2" => "Progressive Conservative Party",
                                "3" => "New Democratic Party (NDP)",
                                "4" => "Bloc Québécois",
                        ],
                        "Answer" => [
                                "Liberal Party",
                                "New Democratic Party (NDP)",
                                "Bloc Québécois"
                        ]
                ]
        ]
];
// Store every quizzes' Questions, Options and Answers

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['topicButton'])) {
    // $_POST => get data sent from an HTML
    // isset() => check if this array element exists and is not null.

    echo "<h2>" . htmlspecialchars($_POST['topicButton']) . "</h2>";
    // htmlspecialchars => Gets the submitted value from the form and make it safe to use in HTML output

    if (($_POST['topicButton']) === 'Trivia') {
        $randomQuiz = $quizArray["trivia"][array_rand($quizArray["trivia"])];
        // array_rand => Extract a random quiz

    } elseif ($_POST['topicButton'] === 'Psychology') {
        $randomQuiz = $quizArray["psychology"][array_rand($quizArray["psychology"])];

    } elseif ($_POST['topicButton'] === 'Canadian Politics') {
        $randomQuiz = $quizArray["politics"][array_rand($quizArray["politics"])];
    }
    $randomQuestion = $randomQuiz["Question"];
    $randomOptions = $randomQuiz["Options"];
    $randomAns = $randomQuiz["Answer"];
    // Store these key in a variable for later use

    echo "<h3>" . htmlspecialchars($randomQuestion) . "</h3>";
    // Topic name

    echo '<form action="">';

    for($i = 0; $i < count($randomOptions); $i++){
        // print every options

        echo '<label class="option">';
        // <label> makes the text clickable.

        echo '<input name ="selectedOption" type="checkbox" value="' . htmlspecialchars($randomOptions[$i+1]) . '">' . htmlspecialchars($randomOptions[$i+1]) . '<br><br>';

        echo '</label>';
    }

    echo '<br><br><button type="button" onclick="checkAns()">Submit</button><br><br><br><br><br><br><br><br>';

    echo '</form>';

    echo '<div id="source" style="display: none;">';
    // Hide the source code first, and display it after the JS function

    show_source(__FILE__);

    echo '</div>';
}
?>

<script>
    function checkAns(){
        const correctAns = <?php echo json_encode($randomAns); ?>;
        const selectedInput = Array.from(document.querySelectorAll('input[name="selectedOption"]:checked'));
        // document.querySelectorAll => Selects all <input> elements that are currently checked, and extract whole element
        // Returns a NodeList, so use Array.from coverts into a real js array

        const selectedValue = selectedInput.map(input => input.value);
        // .map(): for each "input", return its ".value" property

        const labels = document.querySelectorAll('.option');
        // Returns a NodeList

        let rightCount = 0;
        let inputCount = 0;

        for (let i = 0; i < labels.length; i++) {
            const input = labels[i].querySelector('input');

            if (input.checked) {
                if (correctAns.includes(input.value)) {
                    labels[i].style.backgroundColor = 'lightgreen';
                    // set label element background color
                    rightCount++;
                    inputCount++;
                } else {
                    labels[i].style.backgroundColor = 'tomato';
                    inputCount++;
                }
            } else {
                labels[i].style.backgroundColor = '';
            }
        }

        if (selectedValue.length === 0) {
            // Ensure user has selected an option
            alert("Please select an option.");
        }else{
            if(inputCount <= correctAns.length){
                if(rightCount === correctAns.length) {
                    alert("It's all correct!!!");
                    // Display congratulatory message
                }else{
                    alert("You have " + rightCount + " correct, and " + (correctAns.length - rightCount) + " wrong");
                }
            }else{
                alert("This question only have " + correctAns.length + " answers.");
            }
        }
        document.getElementById('source').style.display = 'block';
        // id="course" display source code as a block element
    }
</script>