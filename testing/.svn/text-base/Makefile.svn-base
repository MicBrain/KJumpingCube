# This makefile is defined to give you the following targets:
#
#    default: Same as check
#    check: For each file, F.in, use F.in as input to "java $(MAIN_CLASS)" and
#          compare the output to the contents of the file names F.out.
#          Report discrepencies.
#    clean: Remove all the .class files produced by java compilation, 
#          all Emacs backup files, and testing output files.
#
# You can use this file without understanding most of it, of course, but
# I strongly recommend that you try to figure it out, and where you cannot,
# that you ask questions.  The Lab Reader contains documentation.

PACKAGE = jump61

SHELL = /bin/bash

TESTER = test-jump61

# Flags to Java interpreter: check assertions
JFLAGS = -ea

# Name of class containing main procedure 
MAIN = $(PACKAGE).Main

TESTER_FLAGS =

TESTS := $(wildcard *.in)

.PHONY: default compile check clean

# First, and therefore default, target.
default: check

# Run all tests using test-jump61, after first making sure application
# is compiled.
check: compile
	$(MAKE) -C ..
	@echo "Testing application $(MAIN)..."
	CLASSPATH=../$(CLASSPATH) $(TESTER) *.in

compile:
	$(MAKE) -C ..

# 'make clean' will clean up stuff you can reconstruct.
clean:
	$(RM) -r *~ OUTPUT* *.log *.diff __pycache__
