#!/bin/bash
BASEDIR=$(dirname $0)
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres final_capstone &&
psql -U postgres -d final_capstone -f "$BASEDIR/authTableSetup.sql" &&
psql -U postgres -d final_capstone -f "$BASEDIR/tabelInit.sql" &&
psql -U postgres -d final_capstone -f "$BASEDIR/data.sql" &&
psql -U postgres -d final_capstone -f "$BASEDIR/Breweries.sql" &&
psql -U postgres -d final_capstone -f "$BASEDIR/beers.sql"
