var Observable = require("FuseJS/Observable");

function TaskItem(text, timeSlot, i, image){
	this.text = Observable(text);
	this.timeSlot = Observable(timeSlot);
	this.delay = Observable(i * 0.05);
	this.image = image;
}

var items = Observable(
	new TaskItem("New subpage for Janet", "8 - 10am", 1, "home1"),
	new TaskItem("Catch up with Tom", "11 - 12am Hangouts", 2, "home2"),
	new TaskItem("Lunch with Diane", "12am Restaurant", 3, "home3")
);


module.exports = {
	items: items
};

var Observable = require("FuseJS/Observable");

var done = 25;
var goal = 150;
var progress = (parseInt((done / goal) * 100));

var data = Observable(progress);

module.exports = {
    data: data
};

//Test Grupper
function Gruppe(navn, medlemmer)
{
	this.navn = navn;
	this.medlemmer = medlemmer;
}

var grupper = [
	new Gruppe ("Gruppe 1", 14),
	new Gruppe ("Kiwis gruppe", 25),
	new Gruppe ("Gruppe 3", 50),
	new Gruppe ("Remas gruppe", 1),
	new Gruppe ("Coops gruppe", 8),
	new Gruppe ("Østlands gruppen", 13),
	new Gruppe ("Gruppe 0111", 11),
	new Gruppe ("Gruppe 8", 36)
]

module.exports = {
	grupper: grupper
}

// Code for getting RSS
// var Observable = require("FuseJS/Observable");
// var data = Observable();
// fetch('https://ajax.googleapis.com/ajax/services/feed/load?v=1.0&q=http://www.dagbladet.no/rss/nyheter/').then(function(response) { return response.json(); }).then(function(responseObject) { data.value = responseObject; });
// module.exports = {
//     dataSource: data
// };