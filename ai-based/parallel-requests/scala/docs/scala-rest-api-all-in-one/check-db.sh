#!/bin/bash
sqlite3 data/users.db "SELECT name FROM sqlite_master WHERE type='table';"