#!/bin/bash
basedir=`dirname $0`



DEMO="JBoss Data Grid Getting started Demo"
AUTHORS="Thomas Qvarnstrom, Red Hat"
SRC_DIR=$basedir/installs

JDG_INSTALL=jboss-datagrid-6.4.1-server.zip
#JDG_INSTALL=jboss-datagrid-6.3.0-server.zip

SOFTWARE=(JDG_INSTALL)


# wipe screen.
clear 

echo

ASCII_WIDTH=52

printf "##  %-${ASCII_WIDTH}s  ##\n" | sed -e 's/ /#/g'
printf "##  %-${ASCII_WIDTH}s  ##\n"   
printf "##  %-${ASCII_WIDTH}s  ##\n" "Setting up the ${DEMO}"
printf "##  %-${ASCII_WIDTH}s  ##\n"
printf "##  %-${ASCII_WIDTH}s  ##\n"
printf "##  %-${ASCII_WIDTH}s  ##\n" "    # ####   ###   ###  ###   ####    ###  "
printf "##  %-${ASCII_WIDTH}s  ##\n" "    # #   # #   # #    #      #   #  #     "
printf "##  %-${ASCII_WIDTH}s  ##\n" "    # ####  #   #  ##   ##    #   #  #  ## "
printf "##  %-${ASCII_WIDTH}s  ##\n" "#   # #   # #   #    #    #   #   #  #   # "
printf "##  %-${ASCII_WIDTH}s  ##\n" " ###  ####   ###  ###  ###    ####    ###  "  
printf "##  %-${ASCII_WIDTH}s  ##\n"
printf "##  %-${ASCII_WIDTH}s  ##\n"
printf "##  %-${ASCII_WIDTH}s  ##\n"   
printf "##  %-${ASCII_WIDTH}s  ##\n" "brought to you by,"
printf "##  %-${ASCII_WIDTH}s  ##\n" "${AUTHORS}"
printf "##  %-${ASCII_WIDTH}s  ##\n"
printf "##  %-${ASCII_WIDTH}s  ##\n"
printf "##  %-${ASCII_WIDTH}s  ##\n" | sed -e 's/ /#/g'

echo
echo "Setting up the ${DEMO} environment..."
echo



# Check that maven and docker-compose is installed and on the path
mvn -v -q >/dev/null 2>&1 || { echo >&2 "Maven is required but not installed yet... aborting."; exit 1; }

# Create install dir if not existing
if [[ ! -d $SRC_DIR ]]; then
	echo  - Creating install dir to hold binaries
	echo
	mkdir -p $SRC_DIR
fi

# Verify that necesary files are downloaded

if [[ -r $SRC_DIR/$JDG_INSTALL || -L $SRC_DIR/$JDG_INSTALL ]]; then
		echo $JDG_INSTALL are present...
		echo
elif [[ -r $(find -L ~/software -name $JDG_INSTALL -print -quit) ]]; then
		echo  - $JDG_INSTALL found in shared directory copying it to local install...
		echo
		cp $(find -L ~/software -name $JDG_INSTALL -print -quit) $SRC_DIR
else
		echo You need to download $JDG_INSTALL from the Customer Support Portal 
		echo and place it in the $SRC_DIR directory or ~/software/ to proceed...
		echo
		exit 3
fi


#If JDG is running stop it
echo "  - stopping any running datagrid instances"
echo
jps -lm | grep jboss-datagrid | grep -v grep | awk '{print $1}' | xargs kill -KILL

sleep 2 

# Create the target directory, and if it exists delete it.
if [ -x target ]; then
		echo "  - deleting existing target directory..."
		echo
		rm -rf target
fi
echo "  - creating the target directory..."
echo
mkdir target

echo "  - installing datagrid server"
echo
unzip -q -d target $SRC_DIR/$JDG_INSTALL


echo "EVERYTHING INSTALLED"

echo
echo "For module 2 start JBoss Data Grid server by running the following in a terminal: "                                        
echo "   ./target/jboss-datagrid-*-server/bin/standalone.sh -Djboss.socket.binding.port-offset=100"
 
