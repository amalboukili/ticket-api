import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormLabel from '@material-ui/core/FormLabel';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import Switch from '@material-ui/core/Switch';
import SpeedDial from '@material-ui/lab/SpeedDial';
import SpeedDialIcon from '@material-ui/lab/SpeedDialIcon';
import SpeedDialAction from '@material-ui/lab/SpeedDialAction';
import EditIcon from '@material-ui/icons/Edit';
import PersonIcon from '@material-ui/icons/Person';
import PeopleIcon from '@material-ui/icons/People';
// import ShareIcon from '@material-ui/icons/Share';
// import FavoriteIcon from '@material-ui/icons/Favorite';
import TicketItemsList from '../tikets/TicketItemsList.component';

const useStyles = makeStyles((theme) => ({
  root: {
    transform: 'translateZ(0px)',
    flexGrow: 1,
  },
  exampleWrapper: {
    position: 'relative',
    marginTop: theme.spacing(3),
    height: 380,
  },
  radioGroup: {
    margin: theme.spacing(1, 0),
  },
  speedDial: {
    position: 'absolute',
    '&.MuiSpeedDial-directionUp, &.MuiSpeedDial-directionLeft': {
      bottom: theme.spacing(2),
      right: theme.spacing(2),
    },
    '&.MuiSpeedDial-directionDown, &.MuiSpeedDial-directionRight': {
      top: theme.spacing(2),
      left: theme.spacing(2),
    },
  },
}));

const actions = [
  { icon: <EditIcon />, name: 'Add ticket' },
  { icon: <PersonIcon />, name: 'Add user' },
  { icon: <PeopleIcon />, name: 'Users list' },
  // { icon: <ShareIcon />, name: 'Share' },
  // { icon: <FavoriteIcon />, name: 'Like' },
];

export default function FloatButton() {
  const classes = useStyles();
  const [direction, setDirection] = useState('up');
  const [open, setOpen] = useState(false);
  const [hidden, setHidden] = useState(false);

  const handleDirectionChange = (event) => {
    setDirection(event.target.value);
  };

  const handleHiddenChange = (event) => {
    setHidden(event.target.checked);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleOpen = () => {
    setOpen(true);
  };

  return (
    <div className={classes.root}>
      <FormLabel className={classes.radioGroup} component="legend">
        Direction
      </FormLabel>
      <RadioGroup
        aria-label="direction"
        name="direction"
        value={direction}
        onChange={handleDirectionChange}
        row
      >
        <FormControlLabel value="up" control={<Radio />} label="Right-Up" />
        <FormControlLabel value="down" control={<Radio />} label="Left-Down" />
      </RadioGroup>
      <div className={classes.exampleWrapper}>
        <TicketItemsList />
        <SpeedDial
          ariaLabel="Ticket Actions"
          className={classes.speedDial}
          hidden={hidden}
          icon={<SpeedDialIcon />}
          onClose={handleClose}
          onOpen={handleOpen}
          open={open}
          direction={direction}
        >
          {actions.map((action) => (
            <SpeedDialAction
              key={action.name}
              icon={action.icon}
              tooltipTitle={action.name}
              onClick={handleClose}
            />
          ))}
        </SpeedDial>
      </div>
      {/* //{' '} */}
      <FormControlLabel
        control={
          <Switch
            checked={hidden}
            onChange={handleHiddenChange}
            value="hidden"
            color="primary"
          />
        }
        label="Hidden"
      />
    </div>
  );
}
