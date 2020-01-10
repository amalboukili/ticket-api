import React, { Fragment } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import ListItem from '@material-ui/core/ListItem';
import ListItemAvatar from '@material-ui/core/ListItemAvatar';
import Avatar from '@material-ui/core/Avatar';
import ListItemText from '@material-ui/core/ListItemText';
import Divider from '@material-ui/core/Divider';
import Typography from '@material-ui/core/Typography';
import { Paper, Grid } from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
  //   inline: {
  //     display: 'inline',
  //   },
  paper: {
    maxWidth: 500,
    margin: `${theme.spacing(1)}px auto`,
    padding: theme.spacing(2),
  },
}));
function Ticket() {
  const classes = useStyles();

  return (
    // <ListItem alignItems="flex-start">
    //   <ListItemAvatar>
    //     <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
    //   </ListItemAvatar>
    //   <ListItemText
    //     primary="Brunch this weekend?"
    //     secondary={
    //       <Fragment>
    //         <Typography
    //           component="span"
    //           variant="body2"
    //           className={classes.inline}
    //           color="textPrimary"
    //         >
    //           Ali Connors
    //         </Typography>
    //         {" — I'll be in your neighborhood doing errands this…"}
    //       </Fragment>
    //     }
    //   />
    // </ListItem>
    <Paper className={classes.paper}>
      <Grid container wrap="nowrap" spacing={2}>
        <Grid item>
          <Avatar>W</Avatar>
        </Grid>
        <Grid item xs zeroMinWidh>
          <Typography nowrop>#ID 10, this is my ticket</Typography>
        </Grid>
      </Grid>
    </Paper>
  );
}

export default Ticket;
