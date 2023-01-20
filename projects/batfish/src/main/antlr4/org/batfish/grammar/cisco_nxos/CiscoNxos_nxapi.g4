parser grammar CiscoNxos_nxapi;

import CiscoNxos_common;

options {
  tokenVocab = CiscoNxosLexer;
}

s_nxapi
:
  NXAPI
  (
    (HTTPS (PORT port_number = uint32)?)
    | (HTTP (PORT port_number = uint32)?)
    | nxapi_use_vrf
  )
  NEWLINE
;

nxapi_use_vrf
:
  USE_VRF vrf = vrf_name
;