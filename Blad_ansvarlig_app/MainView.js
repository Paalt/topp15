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

// Code for getting RSS
// var Observable = require("FuseJS/Observable");
// var data = Observable();
// fetch('https://ajax.googleapis.com/ajax/services/feed/load?v=1.0&q=http://www.dagbladet.no/rss/nyheter/').then(function(response) { return response.json(); }).then(function(responseObject) { data.value = responseObject; });
// module.exports = {
//     dataSource: data
// };