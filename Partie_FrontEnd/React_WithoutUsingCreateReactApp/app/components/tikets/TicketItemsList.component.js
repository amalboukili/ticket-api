// @flow
import React, { Fragment } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import Divider from '@material-ui/core/Divider';
import ListItemText from '@material-ui/core/ListItemText';
import ListItemAvatar from '@material-ui/core/ListItemAvatar';
import Avatar from '@material-ui/core/Avatar';
import Typography from '@material-ui/core/Typography';
import Ticket from './Ticket.component';

const useStyles = makeStyles((theme) => ({
  root: {
    // position: 'relative',
    // margin: 'auto',
    // marginTop: theme.spacing(1),
    // width: '100%',
    // maxWidth: 360,
    // backgroundColor: theme.palette.background.paper,
    flexGrow: 1,
    overflow: 'hidden',
    padding: theme.spacing(0, 3),
  },
}));

export default function TicketItemsList() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      {[1, 2, 3].map(() => (
        <Ticket />
      ))}
    </div>
  );
}
