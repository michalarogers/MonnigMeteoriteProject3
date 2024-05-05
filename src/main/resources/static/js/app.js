// Function to fetch and display all meteorite samples
function fetchAllMeteoriteSamples() {
    fetch('/api/meteoriteSamples')
        .then(response => response.json())
        .then(samples => {
            const resultsContainer = document.getElementById('results');
            resultsContainer.innerHTML = '';
            samples.forEach(sample => {
                const div = document.createElement('div');
                div.textContent = `Name: ${sample.name}, Class: ${sample.classType}`;
                resultsContainer.appendChild(div);
            });
        })
        .catch(error => console.error('Error:', error));
}

// Function to add a new meteorite sample
function addMeteoriteSample(sampleData) {
    fetch('/api/meteoriteSamples', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(sampleData)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Sample added:', data);
            alert('Meteorite sample added successfully!');
            fetchAllMeteoriteSamples(); // Refresh list after adding
        })
        .catch(error => console.error('Error:', error));
}

// Function to modify a meteorite sample
function modifyMeteoriteSample(id, updatedData) {
    fetch(`/api/meteoriteSamples/${id}`, {
        method: 'PUT',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(updatedData)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Sample modified:', data);
            alert('Meteorite sample updated successfully!');
            fetchAllMeteoriteSamples(); // Refresh list after updating
        })
        .catch(error => console.error('Error:', error));
}

// Function to delete a meteorite sample
function deleteMeteoriteSample(id) {
    fetch(`/api/meteoriteSamples/${id}`, {method: 'DELETE'})
        .then(response => {
            if (response.ok) {
                alert('Meteorite sample deleted successfully!');
                fetchAllMeteoriteSamples(); // Refresh list after deleting
            }
        })
        .catch(error => console.error('Error:', error));
}

// Advanced Search for Meteorite Samples
document.getElementById('searchForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const name = encodeURIComponent(document.getElementById('name').value);
    const monnigNumber = encodeURIComponent(document.getElementById('monnigNumber').value);
    const country = encodeURIComponent(document.getElementById('country').value);
    const classType = encodeURIComponent(document.getElementById('classType').value);
    const group = encodeURIComponent(document.getElementById('group').value);
    const yearFound = encodeURIComponent(document.getElementById('yearFound').value);
    const sampleWeight = encodeURIComponent(document.getElementById('sampleWeight').value);

    const query = new URLSearchParams({
        name, monnigNumber, country, classType, group, yearFound, sampleWeight
    }).toString();

    fetch(`/api/meteoriteSamples/search?${query}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok: ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            const resultsContainer = document.getElementById('results');
            resultsContainer.innerHTML = '';
            data.forEach(sample => {
                const div = document.createElement('div');
                div.textContent = `Name: ${sample.name}, Number: ${sample.monnigNumber}, Country: ${sample.country}`;
                resultsContainer.appendChild(div);
            });
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            document.getElementById('results').innerHTML = '<p>Error fetching data.</p>';
        });
});

// Load initial data on page load
document.addEventListener('DOMContentLoaded', function() {
    fetchAllMeteoriteSamples();
});
