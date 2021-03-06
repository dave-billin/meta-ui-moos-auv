DESCRIPTION = "Console-only image for the U of I MOOS AUV BSD board"
LICENSE = "GPLv2"

# This image modifies the contents of the gumstix console-only image
require recipes-images/gumstix/gumstix-console-image.bb

# Don't include splash screen functionality
IMAGE_FEATURES_remove = "splash"

# Add documentation, development tools, debuggers and libraries to the image
IMAGE_FEATURES += " \
  dev-pkgs \
  doc-pkgs \
  tools-sdk \
  tools-debug \
"

# Add some useful development tools to the image
# TODO: octave
DEV_TOOLS_INSTALL += " \
  git \
  lua \
  python \
  quilt \
  rsync \
  valgrind \
"

# Remove media tools
MEDIA_TOOLS_INSTALL_remove = " \
  media-ctl \
  raw2rgbpnm \
  v4l-utils \
  yavta \
"

# Remove graphics libraries
GRAPHICS_LIBS_remove = " \
  mtdev \ 
  tslib \
"  

#==========================================
# Additional software packages to install
#==========================================

# TODO: chrony \
#CORE_IMAGE_EXTRA_INSTALL += " \
#"

# Create a generic 'auvuser' user account, part of the auvuser group,
# using '/bin/sh' and with a home directory '/home/auvuser' (see
# /etc/default/useradd).  We set the password to 'auvuser' and add this
# user to the 'sudo' group.
inherit extrausers
EXTRA_USERS_PARAMS = " \
    useradd -P auvuser -G sudo auvuser; \
"
