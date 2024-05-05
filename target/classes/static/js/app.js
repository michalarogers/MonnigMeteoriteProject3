document.getElementById('searchForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const classType = document.getElementById('classType').value;
    const group = document.getElementById('group').value;
    const country = document.getElementById('country').value;
    const query = new URLSearchParams({
        name,
        classType,
        group,
        country
    }).toString();
    fetch(`/api/meteoriteSamples/search?${query}`)
        .then(response => response.json())
        .then(samples => {
            const resultsContainer = document.getElementById('results');
            resultsContainer.innerHTML = ''; // Clear previous results
            if (samples.length > 0) {
                samples.forEach(sample => {
                    const div = document.createElement('div');
                    div.classList.add('result-item');
                    div.textContent = `Name: ${sample.name}, Class: ${sample.classType}, Group: ${sample.group}, Country: ${sample.country}`;
                    resultsContainer.appendChild(div);
                });
            } else {
                resultsContainer.innerHTML = '<p>No matching samples found.</p>';
            }
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            const resultsContainer = document.getElementById('results');
            resultsContainer.innerHTML = '<p>Error fetching data.</p>';
        });
});
