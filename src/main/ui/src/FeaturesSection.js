import React from 'react';

const FeaturesSection = () => {
  return (
    <div className="container text-center my-5">
      <h2 className="mb-4">Features</h2> {/* Added margin bottom for spacing between title and cards */}
      <div className="row">
        {/* Use col-sm-12 for full width on smaller screens and col-lg-4 for larger screens */}
        <div className="col-sm-12 col-md-6 col-lg-4 mb-3"> {/* Added mb-3 for spacing between cards on smaller screens */}
          <div className="card h-100 shadow-sm"> {/* Added shadow for better depth perception */}
            <div className="card-body d-flex flex-column"> {/* Flex layout for internal spacing */}
              <h5 className="card-title">Real-time Availability</h5>
              <p className="card-text">Check which machines are available in real-time.</p>
              <div className="mt-auto"> {/* Pushes button to bottom of card */}
                <button className="btn btn-primary mt-2">Learn More</button> {/* Optional button for more interaction */}
              </div>
            </div>
          </div>
        </div>
        <div className="col-sm-12 col-md-6 col-lg-4 mb-3">
          <div className="card h-100 shadow-sm">
            <div className="card-body d-flex flex-column">
              <h5 className="card-title">Easy Reservations</h5>
              <p className="card-text">Reserve your favorite machines ahead of time.</p>
              <div className="mt-auto">
                <button className="btn btn-primary mt-2">Learn More</button>
              </div>
            </div>
          </div>
        </div>
        <div className="col-sm-12 col-md-6 col-lg-4 mb-3">
          <div className="card h-100 shadow-sm">
            <div className="card-body d-flex flex-column">
              <h5 className="card-title">Notifications</h5>
              <p className="card-text">Get notified when machines become available.</p>
              <div className="mt-auto">
                <button className="btn btn-primary mt-2">Learn More</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default FeaturesSection;



