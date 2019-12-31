import React from 'react';
import styled, { ThemeProvider } from 'styled-components';
import Container from '@material-ui/core/Container';
import { createMuiTheme } from '@material-ui/core/styles';
import NoSsr from '@material-ui/core/NoSsr';
import { palette, spacing, typography } from '@material-ui/system';

const Box = styled.div`${palette}${spacing}${typography}`;
const theme = createMuiTheme();

function Home() {
  return (
    <NoSsr>
      <ThemeProvider theme={theme}>
        <Box
          color="primary.main"
          bgcolor="backgound.paper"
          fontFamily="h6.fontFamily"
          fontSize={{ xs: 'h6.fontSize', sm: 'h4.fontSize', md: 'h3.fontSize' }}
          p={{ xs: 2, sm: 3, md: 4 }}
        >
          @material-ui/system
        </Box>
        <Container>Application content</Container>
      </ThemeProvider>
    </NoSsr>
  );
}

export default Home;
