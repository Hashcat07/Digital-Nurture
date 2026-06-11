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