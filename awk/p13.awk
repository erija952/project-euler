#!/bin/sh
awk '{sum +=$1} END{printf("%10.f",sum)}' $1