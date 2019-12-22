/* eslint-disable prefer-destructuring */
import React, { useState } from 'react';
import PropTypes from 'prop-types';

const getFontSize = (workouts) => {
  let rows = 0;
  workouts.forEach((section) => {
    rows += section.split('\n').length;
  });

  if (rows < 8) return 'f4 f2-ns';
  if (rows < 9) return 'f5 f2-ns';
  if (rows < 14) return 'f5 f2-ns';
  if (rows < 17) return 'f5 f3-ns';
  if (rows < 17) return 'f5 f4-ns';
  if (rows < 20) return 'f5 f4-ns';
  if (rows < 24) return 'f5 f4-ns';
  return 'f5';
};

const Workouts = ({ className, workouts }) => {
  let [currentFontSize] = useState('f7');
  let workoutValue = <div>No workout registered today</div>;

  currentFontSize = getFontSize(workouts);

  if (workouts !== 'undefined') {
    workoutValue = workouts.map((workout) => (
      <div className="pb3">
        {
          workout.split('\n')
            // eslint-disable-next-line react/no-array-index-key
            .map((text, j) => <div className={`georgia lh-title pb2 pb1-ns ${currentFontSize}`} key={j}>{text}</div>)
        }
      </div>
    ));
  }

  return (
    <div className={`mb2  ${className}`}>
      {workoutValue}
    </div>
  );
};

Workouts.defaultProps = {
  className: '',
  workouts: [],
};

Workouts.propTypes = {
  className: PropTypes.string,
  workouts: PropTypes.arrayOf(PropTypes.string),
};

export default Workouts;