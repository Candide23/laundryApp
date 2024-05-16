import React from 'react';

const Testimonials = () => {
  return (
    <div className="container my-5">
      <h2 className="text-center">Testimonials</h2>
      <div id="carouselExampleControls" className="carousel slide" data-ride="carousel">
        <div className="carousel-inner">
          <div className="carousel-item active">
            <p className="text-center">"This app has simplified how I do my laundry weekly!" - Jane Doe</p>
          </div>
          <div className="carousel-item">
            <p className="text-center">"Incredibly convenient and easy to use. A must-have for apartment dwellers." - John Smith</p>
          </div>
        </div>
        <a className="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
          <span className="carousel-control-prev-icon" aria-hidden="true"></span>
          <span className="sr-only">Previous</span>
        </a>
        <a className="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
          <span className="carousel-control-next-icon" aria-hidden="true"></span>
          <span className="sr-only">Next</span>
        </a>
      </div>
    </div>
  );
};

export default Testimonials;

