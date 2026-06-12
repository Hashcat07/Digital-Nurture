let formSubmitted = false;

function confirmSubmit() {
  formSubmitted = true;
  document.getElementById("confirmation").textContent =
    "Registration submitted successfully!";
}

window.onbeforeunload = function () {
  if (!formSubmitted) {
    return "You have unsaved changes!";
  }
};

function validatePhone() {
  let phone = document.getElementById("phone").value;
  if (phone.length !== 10) {
    alert("Phone must be 10 digits");
  }
}

function showFee() {
  let type = document.getElementById("eventType").value;
  let fee = 0;

  if (type === "Workshop") fee = 100;
  if (type === "Music") fee = 75;
  if (type === "Sports") fee = 50;

  document.getElementById("fee").textContent = "Fee: $" + fee;
}

function enlarge(img) {
  img.style.width = "300px";
}

function countChars() {
  let count = document.getElementById("feedback").value.length;
  document.getElementById("counter").textContent = count + " characters";
}

function videoReady() {
  document.getElementById("videoStatus").textContent = "Video ready to play";
}

function savePreference() {
  let value = document.getElementById("eventType").value;

  localStorage.setItem("preferredEvent", value);
  sessionStorage.setItem("preferredEvent", value);
}

window.onload = function () {
  let saved = localStorage.getItem("preferredEvent");

  if (saved) {
    document.getElementById("eventType").value = saved;
  }

  alert("Page loaded successfully");
};

function clearPreferences() {
  localStorage.clear();
  sessionStorage.clear();

  document.getElementById("eventType").selectedIndex = 0;
}

function findNearbyEvents() {
  if (!navigator.geolocation) {
    document.getElementById("location").textContent =
      "Geolocation is not supported by your browser";
    return;
  }

  navigator.geolocation.getCurrentPosition(showPosition, showError, {
    enableHighAccuracy: true,
    timeout: 5000,
  });
}

function showPosition(position) {
  document.getElementById("location").innerHTML =
    "Latitude: " +
    position.coords.latitude +
    "<br>Longitude: " +
    position.coords.longitude;
}

function showError(error) {
  switch (error.code) {
    case error.PERMISSION_DENIED:
      document.getElementById("location").textContent = "Permission denied";
      break;

    case error.TIMEOUT:
      document.getElementById("location").textContent = "Request timed out";
      break;

    default:
      document.getElementById("location").textContent =
        "Unable to retrieve location";
  }
}

console.log("Welcome to the Community Portal");

const eventName = "Community Music Festival";
const eventDate = "2026-07-15";
let availableSeats = 50;

console.log(
  `Event: ${eventName}, Date: ${eventDate}, Seats: ${availableSeats}`
);

availableSeats--;

console.log(`Remaining Seats: ${availableSeats}`);

const events = [
  { name: "Music Festival", seats: 20, upcoming: true },
  { name: "Old Workshop", seats: 0, upcoming: false },
  { name: "Sports Day", seats: 15, upcoming: true },
];

events.forEach((event) => {
  if (event.upcoming && event.seats > 0) {
    console.log(event.name);
  }
});

try {
  let seats = 10;

  if (seats <= 0) {
    throw new Error("No seats available");
  }

  seats--;
} catch (error) {
  console.error(error.message);
}

function addEvent(name) {
  console.log("Event Added: " + name);
}

const registerUser = function (userName) {
  console.log(userName + " registered successfully");
};

function eventCounter() {
  let count = 0;

  return function () {
    count++;
    console.log("Registrations: " + count);
  };
}

const countRegistration = eventCounter();

countRegistration();
countRegistration();

const eventsList = [
  { name: "Workshop", fee: 100 },
  { name: "Music", fee: 75 },
  { name: "Sports", fee: 50 }
];

const affordableEvents = eventsList.filter(
  (event) => event.fee <= 75
);

console.log(affordableEvents);

addEvent("Music Festival");
registerUser("Ray");

const eventDetails = {
  name: "Community Workshop",
  date: "2026-07-15",
  fee: 100,

  displayInfo() {
    console.log(
      `${this.name} on ${this.date} - Fee: $${this.fee}`
    );
  },
};

eventDetails.displayInfo();

function Event(name, fee) {
  this.name = name;
  this.fee = fee;
}

Event.prototype.showFee = function () {
  console.log(`${this.name} Fee: $${this.fee}`);
};

const musicEvent = new Event("Music Festival", 75);

musicEvent.showFee();

class CommunityEvent {
  constructor(name, fee) {
    this.name = name;
    this.fee = fee;
  }

  showDetails() {
    console.log(`${this.name} - $${this.fee}`);
  }
}

class PremiumEvent extends CommunityEvent {
  constructor(name, fee, perks) {
    super(name, fee);
    this.perks = perks;
  }

  showPerks() {
    console.log(`Perks: ${this.perks}`);
  }
}

const premium = new PremiumEvent(
  "VIP Music Festival",
  150,
  "Front Row Seating"
);

premium.showDetails();
premium.showPerks();

const communityEvents = [
  { name: "Workshop", fee: 100 },
  { name: "Music", fee: 75 },
  { name: "Sports", fee: 50 },
];

const eventNames = communityEvents.map(
  (event) => event.name
);

console.log(eventNames);

const lowCostEvents = communityEvents.filter(
  (event) => event.fee <= 75
);

console.log(lowCostEvents);

const musicEventData = communityEvents.find(
  (event) => event.name === "Music"
);

console.log(musicEventData);

const totalFees = communityEvents.reduce(
  (sum, event) => sum + event.fee,
  0
);

console.log(totalFees);

const [firstEvent, secondEvent] = communityEvents;

console.log(firstEvent);
console.log(secondEvent);

const additionalEvents = [
  ...communityEvents,
  { name: "Art", fee: 60 },
];

console.log(additionalEvents);

function addBulletin() {
  const container = document.getElementById("bulletinContainer");

  const bulletin = document.createElement("p");

  bulletin.textContent =
    "New community cleanup drive scheduled for this Sunday.";

  container.appendChild(bulletin);
}

function removeBulletin() {
  const container = document.getElementById("bulletinContainer");

  if (container.lastElementChild) {
    container.removeChild(container.lastElementChild);
  }
}

function addBulletin() {
  const container = document.getElementById(
    "bulletinContainer"
  );

  const bulletin = document.createElement("p");

  bulletin.textContent =
    "New community cleanup drive scheduled for this Sunday.";

  bulletin.style.color = "blue";

  container.appendChild(bulletin);
}

function removeBulletin() {
  const container = document.getElementById(
    "bulletinContainer"
  );

  if (container.lastElementChild) {
    container.removeChild(container.lastElementChild);
  }
}

document
  .getElementById("addNewsBtn")
  .addEventListener("click", function (event) {
    event.preventDefault();

    const newsList =
      document.getElementById("newsList");

    const item = document.createElement("li");

    item.textContent = "Community Cleanup Drive";

    newsList.appendChild(item);
  });

document
  .getElementById("newsList")
  .addEventListener("click", function (event) {
    console.log(
      "Clicked:",
      event.target.textContent
    );
  });

  function fetchEvents() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve([
        "Music Festival",
        "Sports Day",
        "Book Fair"
      ]);
    }, 2000);
  });
}

async function loadEvents() {
  const events = await fetchEvents();

  const list = document.getElementById("eventData");

  list.innerHTML = "";

  events.forEach((event) => {
    const item = document.createElement("li");

    item.textContent = event;

    list.appendChild(item);
  });
}

document
  .getElementById("loadEventsBtn")
  .addEventListener("click", loadEvents);

  function registerParticipant(name = "Guest") {
  console.log(`${name} registered`);
}

registerParticipant();
registerParticipant("Ray");

function totalFees(...fees) {
  return fees.reduce((sum, fee) => sum + fee, 0);
}

console.log(totalFees(100, 75, 50));

const eventInfo = {
  eventName: "Music Festival",
  eventFee: 75,
};

const { eventName, eventFee } = eventInfo;

console.log(eventName);
console.log(eventFee);

document
  .getElementById("registrationForm")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const name = form.elements["name"].value;
    const email = form.elements["email"].value;

    let valid = true;

    if (name.trim() === "") {
      document.getElementById("nameError").textContent =
        "Name is required";
      valid = false;
    }

    if (email.trim() === "") {
      document.getElementById("emailError").textContent =
        "Email is required";
      valid = false;
    }

    if (valid) {
      document.getElementById("confirmation").textContent =
        "Registration submitted successfully!";
    }
  });

  function submitRegistration() {
  const user = {
    name: document.querySelector("#name").value,
    email: document.getElementById("email").value,
  };

  setTimeout(() => {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      body: JSON.stringify(user),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then(() => {
        console.log("Registration successful");
      })
      .catch(() => {
        console.log("Registration failed");
      });
  }, 2000);
}

$("#registerBtn").click(function () {
  $(".eventCard").fadeOut(1000).fadeIn(1000);
});