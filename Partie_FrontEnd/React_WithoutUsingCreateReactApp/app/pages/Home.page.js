import React from 'react';
import { ThemeProvider } from 'styled-components';
import { palette, spacing, typography } from '@material-ui/system';
import Container from '@material-ui/core/Container';
import { createMuiTheme, makeStyles } from '@material-ui/core/styles';
import NoSsr from '@material-ui/core/NoSsr';
import SearchAppBar from '../components/layout/SearchAppBar.component';
import TicketItemsList from '../components/tikets/TicketItemsList.component';
import FloatButton from '../components/speedDials/FloatButton.component';
// import FloatButton from '../components/speedDials/FloatButton.component';

const theme = createMuiTheme();

const useStyles = makeStyles((theme) => ({
  root: {
    padding: theme.spacing(1),
  },
}));

function Home() {
  const classes = useStyles();
  return (
    <NoSsr>
      <ThemeProvider theme={theme}>
        <SearchAppBar />
        <Container className={classes.root}>
          <TicketItemsList />
          <FloatButton />
        </Container>
      </ThemeProvider>
    </NoSsr>
  );
}

export default Home;
