# -*- coding: utf-8  -*-

import re

def fixSourceSchema(match):
    theSchema = match.group(1)
    theSchema = theSchema.replace("_", " ")
    " ".join(theSchema.split())
    return '|Source schema=' + theSchema

def fixTargetSchema(match):
    theSchema = match.group(1)
    theSchema = theSchema.replace("_", " ")
    " ".join(theSchema.split())
    return '|Target schema=' + theSchema

def fixRoleName(match):
    theRole = match.group(1)
    theRole = theRole.lower()
    " ".join(theRole.split())
    return '|Role.Name=' + theRole


fixes['fixSchema'] = {
    'regex': True,
    'msg': {
        '_default':u'Testing the replacement feature for schema',
    },
    'replacements': [
        (ur'\|Source schema=(.+)', fixSourceSchema),
        (ur'\|Target schema=(.+)', fixTargetSchema),
    ]
}

fixes['fixRole'] = {
    'regex': True,
    'msg': {
        '_default':u'Testing the replacement feature for roles',
    },
    'replacements': [
        (ur'\|Role.Name=(.+)', fixRoleName),
    ]
}

