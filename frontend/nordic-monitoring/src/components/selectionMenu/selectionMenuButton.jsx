import React from 'react';
import PropTypes from 'prop-types';

const SelectionMenuButton = ({
  className, text, onClick, disabled,
}) => (
  <button
    type="button"
    className={`ba b--black bg-white dim shadow-1 no-underline near-black ma2 tc pa br3 ${className} ${disabled ? '' : 'dim'}`}
    onClick={onClick}
    disabled={disabled}
    style={{ outline: 0 }}
  >
    <h1 className={`pa2 center futura ttu tracked-mega f3 f2-ns bold ${disabled ? 'light-gray' : ''}`}>
      {text}
    </h1>
  </button>
);

SelectionMenuButton.defaultProps = {
  className: '',
  text: '',
  onClick: () => {},
  disabled: false,
};

SelectionMenuButton.propTypes = {
  className: PropTypes.string,
  text: PropTypes.string,
  onClick: PropTypes.func,
  disabled: PropTypes.bool,
};

export default SelectionMenuButton;
